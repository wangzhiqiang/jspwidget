package net.huaixiu.frame;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.huaixiu.bean.ArticleEntity;
import net.huaixiu.utils.URLUtils;

public class Index extends JFrame {
	private static final long serialVersionUID = 1L;
	private static TextArea text = new TextArea();
	public  static Font font = Font.getFont("微软雅黑");
	private static JFrame frame = new JFrame();

	public void init() {

		JButton all   = new JButton("全本小说");
		JButton top   = new JButton("小说排行");
		JButton btu1  = new JButton("玄幻魔法");
		JButton btu2  = new JButton("武侠修真");
		JButton btu3  = new JButton("都市言情");
		JButton btu4  = new JButton("历史军事");
		JButton btu5  = new JButton("侦探推理");
		JButton btu6  = new JButton("网游动漫");
		JButton btu7  = new JButton("科幻小说");
		JButton btu8  = new JButton("恐怖灵异");
		JButton btu9  = new JButton("散文诗词");
		JButton btu10 = new JButton("其他类型");

		JPanel jp = new JPanel();

		text.setName("text");
		text.setEditable(false);
		jp.add(text);
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = URLUtils
						.content(
								"http://www.huaixiu.net/modules/article/toplist.php",
								"GBK");
				// System.out.println(content);
				List<ArticleEntity> arlist = URLUtils.list(content);
				 for (int i = 0; i < arlist.size(); i++) {
					 System.out.println(arlist.get(i).getAll());
				}
				Index.text.append(content);
			}
		});

		frame.setTitle("沸腾文学自用客户端");
		frame.setFont(font);
		frame.setSize(400, 500);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		// frame.setResizable(false);

		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frame.setLocation((int) (width - 500) / 2, (int) (height - 500) / 2);

		frame.add(all);
		frame.add(top);
		frame.add(btu1);
		frame.add(btu2);
		frame.add(btu3);
		frame.add(btu4);
		frame.add(btu5);
		frame.add(btu6);
		frame.add(btu7);
		frame.add(btu8);
		frame.add(btu9);
		frame.add(btu10);
		frame.add(jp);

		// frame.addWindowListener(new WindowAdapter() {
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// });
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
