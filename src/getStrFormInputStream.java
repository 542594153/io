import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
//汉化
public class getStrFormInputStream {
	@Test
	public void asd() throws IOException{
		String strFormInputStream = getStrFormInputStream("ssssss","ISO-8859-1");
		System.out.println(strFormInputStream);
	}
	

		//这次做一个读取字符串 并转化为自己想要的编码格式
	//用 开发中比较常用的“包装器模式”
   // 我想把字符串转为贴合实际的ByteArrayInputStream,
//再转化为更常用的Reader(InputStreamReader)  再包装上buffer(BufferedReader)。 
	public static String getStrFormInputStream(String str, String encoding) throws IOException {
	 //str.getBytes（）得到一个操作系统默认的编码格式的字节数组
	InputStream inputStream = new ByteArrayInputStream(str.getBytes(encoding));//字节数组输入流
	  BufferedReader bf = null;
	 InputStreamReader inputStreamReader = null;
	    try {
	     inputStreamReader = new InputStreamReader(inputStream);
		        bf = new BufferedReader(inputStreamReader);
   StringBuffer sb = new StringBuffer();
   //使用StringBuilder和StringBuffer比使用String类型更快
   /*速度性能上StringBuilder > StringBuffer > String
    * https://blog.csdn.net/qq_37856300/article/details/84340288
    * 对于string三兄弟的各种性能测试
    * **/
	         String line = "";
		        while ((line = bf.readLine()) != null) {
		          sb.append(line);
	           }
	             return sb.toString();
			         } finally {
	            if (bf != null) {
		               bf.close();
		         }
			            if (inputStreamReader != null) {
		            inputStreamReader.close();
		          }
		            if (inputStream != null) {
	    }
			         }
			     }
}
