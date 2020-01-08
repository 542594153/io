import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class createImage {
/*Image是一个抽象类，BufferedImage是其实现类，是一个带缓冲区图像类，主要作用是将一幅图片加载到内存中（BufferedImage生成的图片在内存里有一个图像缓冲区，利用这个缓冲区我们可以很方便地操作这个图片），提供获得绘图对象、图像缩放、选择图像平滑度等功能，通常用来做图片大小变换、图片变灰、设置透明不透明等。
*/	
	public void createImage(BufferedImage image,
			              String fileLocation) throws IOException {
			          FileOutputStream fos = null;
			          BufferedOutputStream bos = null;
			          try {
			              fos = new FileOutputStream(fileLocation);
			             bos = new BufferedOutputStream(fos);
			            // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
			             // encoder.encode(image);
			             ImageIO.write(image, "JPEG", bos);
			          } catch (Exception e) {
			              e.printStackTrace();
			         } finally {
			              if (fos != null) {
			                  fos.close();
			              }
			              if (bos != null) {
			                 bos.close();
			              }
			       }
			      }
	
	
	
	
}
