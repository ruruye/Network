package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {

	public static void main(String[] args) {
		// SWING의 파일 열기, 저장 창 연습
		
		JFileChooser chooser = new JFileChooser();
		
		// 선택할 파일의 확장자 설정
		FileNameExtensionFilter txt = new FileNameExtensionFilter("Text파일(*.txt)", "txt");
		FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF 파일", "pdf");
		FileNameExtensionFilter img = new FileNameExtensionFilter("이미지 파일", "png", "jpg", "gif");
		FileNameExtensionFilter doc = new FileNameExtensionFilter("MS Word파일", new String[] {"docx", "doc"});
		
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(pdf);
		chooser.addChoosableFileFilter(txt);
		
		chooser.setFileFilter(img);  // 확장자 목록 중 기본적으로 선택될 확장자 지정
		
		// 모든 파일 목록의 표시 여부를 설정한다.(true : 설정, false : 미설정)
		chooser.setAcceptAllFileFilterUsed(true);
		
		// Dialog창에 나타날 기본 경로 설정하기 (예) 'f:/d_other' 폴더로 설정하기)
		chooser.setCurrentDirectory(new File("f:/d_other"));
		
		// 창 열기
		int result = chooser.showOpenDialog(new Panel()); // 열기용 창
//		int result = chooser.showSaveDialog(new Panel()); // 저장용 창
		
		// 창에서 파일을 선택한 후 '저장' 또는 '열기'버튼을 눌렀을 때(APPROVE_OPTION) 처리하기
		if(result==JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			System.out.println("선택한 파일 : " + selectedFile.getAbsolutePath());
		}
	}

}
