package lib;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class Snippet {
	//NVelocity摸板引擎  好难 研究不会   课下自己感兴趣 自己研究
	public void exportByModel(List<Map<String, Object>> data,
	            byte[] exportModel,
	            String fileNameLocation) throws Exception {
	        InputStream in = null;
	        Reader reader = null;
	        OutputStream out = null;
	        Writer des = null;
	        CharArrayWriter writer = null;
	        try {
	            // 读取模板
	            in = new ByteArrayInputStream(exportModel);
	            reader = new InputStreamReader(in);
	            // 设置输出位置
	            out = new FileOutputStream(fileNameLocation);
	            String encoding = "GBK";
	            try {
	                des = new OutputStreamWriter(out, encoding);// 不设置utf-8,中文不支持
	            } catch (Exception e) {
	                des = new OutputStreamWriter(out, "GBK");// 编码设置异常，直接按照GBK输出
	            }
	            // 执行
	            writer = VelocityHelper.getInstance().evaluateToWriter(data, reader);//NVelocity摸板引擎   好牛逼，老衲不会
	            writer.writeTo(des);
	            des.flush();
	        } catch (Exception e) {
	            throw new  Exception("写入文件异常");
	        } finally {
	            if (writer != null)
	                writer.close();
	            if (des != null)
	                des.close();
	            if (out != null)
	                out.close();
	            if (reader != null)
	                reader.close();
	            if (in != null)
	                in.close();
	        }
	    }
}