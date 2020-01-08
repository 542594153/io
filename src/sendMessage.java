import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class sendMessage {
//当我查看资料的时候，发现实际业务中 绝大多数输出都是输出到文件的。聊天通讯就不做了，做一个文件读写
	
	/**
	 * 1常用的文件基本操作
	 * String filePath = "D:\\";
        File file = new File(filePath);
        long length = 0;
        if (file.exists()){
            length = file.length();
        }else{
           file.mkdirs();
        }
      2  当你读写文件的时候，看到直接读取字节实际上应用更广一点，当然用读取字符也是占很大比重
      		反正就是你想用那个就用那个，无所谓
	 * @throws UnsupportedEncodingException 
      
        

	 * */
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytesByFileName = getBytesByFileName("D:/items/asd.txt");
		
		String res = new String(bytesByFileName,"UTF-8");
		/*for (byte b : bytesByFileName) {
			a+=b;
			
		}*/System.out.println(res);
	
	}
	
	
	
	public static byte[] getBytesByFileName(String filePath) {
		byte[] buffer=null;
		try {
           File file = new File(filePath);
			//File file = new File("C:\Users\shenghui\Desktop\赵晟晖话术\io流讲课（临时）\流程图复习");
            FileInputStream fis = new FileInputStream(file);//把文件输入到eclipse
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);//设定一次存放多少
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {//接收屏幕输入，存入b,同时读取的个数赋值给n
            	/*    
            	 * 
            	 *     
        write（）系列方法进行写操作时并不一定直接将所写的内容写出，
        而先将需要写出的内容放到输出缓冲区，
        知道缓冲去满、调用flush（）方法刷新流或调用close（）方法关闭流时才真正输出。
        这样处理可以减少实际的写出次数，提高系统效率。减少内存的占用
        如果需要写出的内容立即输出，需要在完成write（）方法后
        调用flush（）方法刷新流，否则程序可能不能正常工作。*/
                bos.write(b, 0, n);
            }
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
	
	
	
	
}
