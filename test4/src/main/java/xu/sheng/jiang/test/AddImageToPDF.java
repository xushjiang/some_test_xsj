package xu.sheng.jiang.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class AddImageToPDF {

	private static String systom_path = System.getProperty("user.dir");
	private static String PDF_IMAGE_PATH = systom_path + "/src/main/webapp/resources/image/pdfImage.png";
	private static String PDF_PATH = systom_path + "/src/main//webapp/resources/image/oldPdf.pdf";
	private static String PDF_NEW_PATH = "E://creatFile//files//1.pdf";

	public static void addImage() throws Exception {

		File file = new File(PDF_NEW_PATH);
		file.getParentFile().mkdirs();

		PdfReader reader = new PdfReader(PDF_PATH);// 读入原始pdf
		PdfStamper stamer = new PdfStamper(reader, new FileOutputStream(new File(PDF_NEW_PATH)));

		Rectangle rect = reader.getPageSize(1);// 获取第一页的大小
		Image image = Image.getInstance(PDF_IMAGE_PATH);// 实例化图片
		float image_w = 150;// 图片宽度
		float iamge_h = 60;// 图片高度
		image.setAbsolutePosition(rect.getWidth() - image_w - 20, 20);// 第一个参数是右移，第二个参数是上移
		image.scaleAbsolute(image_w, iamge_h);// 设置图片大小

		PdfContentByte over = stamer.getOverContent(reader.getNumberOfPages());
		over.addImage(image);
		stamer.close();
		reader.close();

	}

	public static void main(String[] args) {

		try {
			addImage();
			System.out.println(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
