import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class moveFile {
	
	public static void main(String[] args) throws Exception {
		movefile("D:/items/asds.txt","D:/item/asds.txt");
	}
	
	

	// 移动文件：实际上就是从一个文件中读取文件，然后写到另一个文件中，
	// 这算是一个非常详细的例子。
	// 分析代码：我想判断源文件是否存在，
	// 我再去创建目标文件夹和目标文件，当然，你也可以不用mkdir()
	// 直接用 mkdirs()也行。
	// 当然我写文件时的数据（调用write()方法传入的数据）不一定是来自文件也有可能来自一个list,一个byte[]数组。
	// sourcePath第一个文件路径 targetPath转移的路径
	public static void movefile(String sourcePath, String targetPath) throws Exception {
		File sourceRoot = new File(sourcePath);
		if (!sourceRoot.exists()) {
			throw new Exception("要移动的文件不存在");
		}
		if (sourceRoot.isFile()) {
			boolean success = true;
			File targetFile = new File(targetPath);
			if (!targetFile.getParentFile().exists()) {//getParentFile()的作用是返回此抽象路径名父目录的抽象路径名
				if (!targetFile.getParentFile().mkdirs()) {
					success = false;
				}
			}
			if (!targetFile.exists()) {
				if (!targetFile.createNewFile()) {
					success = false;
				}
			}
			if (!success) {
				throw new Exception("目标目录创建失败");
			}

			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			byte[] d = new byte[1024];
			int length = -1;
			try {
				bis = new BufferedInputStream(new FileInputStream(sourceRoot));
				bos = new BufferedOutputStream(new FileOutputStream(targetFile));
				while ((length = bis.read(d)) != -1) {
					bos.write(d, 0, length);
				}
				bos.flush();
			} catch (IOException e) {
				e.printStackTrace();
				success = false;
			} finally {
				if (bos != null) {
					bos.close();
				}
				if (bis != null) {
					bis.close();
				}
				bos = null;
				bis = null;
			}
			if (success) {
				sourceRoot.deleteOnExit();//deleteOnExit()是在JVM退出的时候才执行的，因此相当于是先调用了createNewFile()再调用deleteOnExit();
			}
		} else {
			File[] files = sourceRoot.listFiles();//是返回某个目录下所有文件和目录的绝对路径，返回的是File数组
			for (File file : files) {
				movefile(file.getAbsolutePath(), targetPath + File.separator + file.getName());
			}
			sourceRoot.deleteOnExit();
		}
	}
	
	
	
	//文件的追加
	public void writeFile(String str,
            File file) throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(file, true); // 是否追加
            byte[] b = str.getBytes();
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
	
	
	
}
