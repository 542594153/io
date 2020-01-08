import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

public class SysoConsole {

	/* 小试牛刀：先做一个简单的控制台输出   by晟晖 */
	@Test
	public void console() {
		/*
		 * System.in是一个很原始、很简陋的输入流对象，通常不直接使用它来读取用户的输入。 一般会在外面封装过滤流：
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); 然后调用br.readLine()方法进行读取。
		 **/
		InputStreamReader isr = new InputStreamReader(System.in); // 创建简单的输入流
		//Scanner scanner = new Scanner(System.in);
		BufferedReader br = new BufferedReader(isr);// 包装过滤流
		String s = null;
		try {
			System.out.println("开始输入。。。");
			s = br.readLine();// 截取一行的数据
			while (s != null) {

				/*
				 * "==": ①基本类型比较的是值； ②引用类型比较的是地址； ③不同类型不能用它比较，无法通过编译。
				 * 
				 * equals（Object obj）： ①用于应用类型的比较；
				 * ②String重写Object的equals方法，先用“==”判断地址，地址相同则直接返回true；然后再比较类型，
				 * 类型不同则直接返回false；
				 * 
				 * char chr = ‘a’，
				 * String str =“a”，
				 * 我经常会写成str.equals(chr)，而且还傻傻的等着返回true
				 * 
				 * equalsIgnoreCase(String str): 虽然也是用来比较的，但是不同于equals，
				 * 它是String自己的方法而不是重写Object的方法， 只有String对象能调用，而且入参只能是String。
				 *
				 */
				if (s.equalsIgnoreCase("yes"))
				break;
			//toUpperCase把字符变成大写
			System.out.println(s.toUpperCase());
			System.out.println("是否停止输入（yes/no）");
			s = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 流一定得关闭，这是底线，关闭的顺序：先声明的后关闭
			}
		}
	}

}
