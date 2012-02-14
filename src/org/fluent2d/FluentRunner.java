package org.fluent2d;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.fluent2d.resolutions.Resolution;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FluentRunner {

	public static void Run(File outputDir, Theme theme,
			DrawableItem<?>[] drawables, Resolution[] androiddefaults,
			State[] androidactionbardefaults) {

		if (!outputDir.exists() || !outputDir.isDirectory())
			throw new RuntimeException(
					"outputDir must exist and must be a directory");

		for (DrawableItem<?> drawableItem : drawables) {
			for (Resolution res : androiddefaults) {
				for (State state : androidactionbardefaults) {

					Drawable<?> drawable = createDrawable(
							drawableItem.drawableClass(), theme, res, state);
					BufferedImage image = new BufferedImage(res.totalArea()
							.right(), res.totalArea().bottom(),
							BufferedImage.TYPE_4BYTE_ABGR);

					drawable.setup();
					drawable.render(image);

					saveImage(image, outputDir.getAbsolutePath(), res.name(),
							drawableItem.name(), state.name());

				}

			}

			try {
				createSelector(outputDir.getAbsolutePath(), drawableItem,
						androidactionbardefaults);
			} catch (Exception e) {
				throw new RuntimeException("Error creatign selector", e);
			}
		}

	}

	private static Drawable<?> createDrawable(Class<Drawable<?>> klass,
			Theme theme, Resolution resolution, State state) {
		try {
			Constructor<Drawable<?>> constructor = klass.getConstructor(
					Theme.class, Resolution.class, State.class);
			Drawable<?> drawable = constructor.newInstance(theme, resolution,
					state);
			return drawable;
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(
					String.format(
							"Class %s does not have a public constructor with the arguments(Theme, Resolution, State))",
							klass.getName()), e);
		} catch (InstantiationException e) {
			throw new RuntimeException(String.format(
					"An exception was thrown while constructing class '%s'.",
					klass.getName()), e);
		} catch (Exception e) {
			throw new RuntimeException(String.format(
					"Unknown excpetion while creating new drawable '%s'",
					klass.getName()), e);
		}
	}

	private static void saveImage(BufferedImage image,
			String directoryAbsolutePath, String resolutionName,
			String drawableName, String stateName) {

		String fileName = String.format("%s/%s/%s_%s.png",
				directoryAbsolutePath, resolutionName, drawableName, stateName);
		File outputfile = new File(fileName);

		// ensure the folder exists
		outputfile.getParentFile().mkdir();
		outputfile.delete();

		try {
			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			throw new RuntimeException("Error writing image", e);
		}
	}

	public static void createSelector(String directoryAbsolutePath,
			DrawableItem<?> drawable, State[] states)
			throws ParserConfigurationException,
			TransformerFactoryConfigurationError, IOException,
			TransformerException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// create the document
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("selector");
		rootElement.setAttribute("xmlns:android",
				"http://schemas.android.com/apk/res/android");
		doc.appendChild(rootElement);

		for (State state : states) {
			// <item android:drawable="@drawable/home_pressed"
			// android:state_pressed="true" />
			Element item = doc.createElement("item");
			item.setAttribute("android:drawable",
					"@drawable/" + drawable.name() + "_" + state.name);
			rootElement.appendChild(item);

			for (String key : state.attributes.keySet()) {
				item.setAttribute("android:" + key, state.attributes.get(key));
			}
		}

		// write the file
		Transformer transformer;
		transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		// initialize StreamResult with File object to save to file
		String filename = String.format("%s/%s/%s.xml", directoryAbsolutePath,
				"drawable", drawable.name());
		new File(filename).getParentFile().mkdir();
		FileWriter fstream = new FileWriter(filename);
		StreamResult result = new StreamResult(fstream);
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);

		String xmlString = result.getWriter().toString();
		System.out.println(xmlString);
		fstream.flush();
		fstream.close();

	}

}
