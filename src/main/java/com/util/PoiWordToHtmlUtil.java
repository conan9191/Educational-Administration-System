package com.util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.w3c.dom.Document;

public class PoiWordToHtmlUtil {
	private static Logger logger = Logger.getLogger(PoiWordToHtmlUtil.class);
 public static String word2Html(String path,String filename) throws Throwable {
//  final String path = "F:\\";
//  final String file = "a.doc";
  path = path+"\\\\";
  logger.debug("path:"+path);
  logger.debug("filename:"+filename);
  InputStream input = new FileInputStream(path + filename);
  HWPFDocument wordDocument = new HWPFDocument(input);
  WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
    DocumentBuilderFactory.newInstance().newDocumentBuilder()
      .newDocument());
  wordToHtmlConverter.setPicturesManager(new PicturesManager() {
   public String savePicture(byte[] content, PictureType pictureType,
     String suggestedName, float widthInches, float heightInches) {
    return suggestedName;
   }
  });
  wordToHtmlConverter.processDocument(wordDocument);
  List<?> pics = wordDocument.getPicturesTable().getAllPictures();
  if (pics != null) {
   for (int i = 0; i < pics.size(); i++) {
    Picture pic = (Picture) pics.get(i);
    try {
     pic.writeImageContent(new FileOutputStream(path
       + pic.suggestFullFileName()));
    } catch (FileNotFoundException e) {
     e.printStackTrace();
    }
   }
  }
  Document htmlDocument = wordToHtmlConverter.getDocument();
  ByteArrayOutputStream outStream = new ByteArrayOutputStream();
  DOMSource domSource = new DOMSource(htmlDocument);
  StreamResult streamResult = new StreamResult(outStream);
  TransformerFactory tf = TransformerFactory.newInstance();
  Transformer serializer = tf.newTransformer();
  serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
  serializer.setOutputProperty(OutputKeys.INDENT, "yes");
  serializer.setOutputProperty(OutputKeys.METHOD, "html");
  serializer.transform(domSource, streamResult);
  outStream.close();
  String content = new String(outStream.toByteArray());
  //获取。前面的名字
  filename =filename.split("\\.")[0];
  logger.debug("处理后的filename:"+filename);
  FileUtils.writeStringToFile(new File(path, filename+".html"), content, "utf-8");
  filename = filename+".html";
  return filename;
 }
}