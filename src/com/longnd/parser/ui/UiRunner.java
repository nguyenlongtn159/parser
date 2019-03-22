package com.longnd.parser.ui;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;

public class UiRunner extends Canvas implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Frame frame;
	String pathFile;

	public void initUi() {
		frame = new Frame("Parser");
		// Canvas canvas = new UiRunner();
		// canvas.setSize(100, 100);
		// frame.add(canvas);
		frame.setSize(600, 400);

		addButtonExit();
		addButtonSubmit();
		addMenuBar();

		addListSelectWay();

		frame.setLayout(null);
		frame.setVisible(true);

	}

	public void paint(Graphics g) {

	}

	private void addButtonExit() {

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent var1) {
		// TODO Auto-generated method stub
		frame.dispose();
	}

	private void addButtonSubmit() {
		Button buttonSubmit = new Button("Submit");
		// buttonSubmit.setBackground(Color.RED);
		buttonSubmit.setVisible(true);
		buttonSubmit.setBounds(50, 200, 100, 30);

		Label label = new Label("mmm");
		label.setBounds(50, 80, 300, 30);
		label.setVisible(true);
		frame.add(label);
		buttonSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent var1) {
				label.setText(pathFile);

				if (buttonSubmit.getBackground().equals(Color.GREEN)) {
					buttonSubmit.setBackground(Color.RED);

				} else {
					buttonSubmit.setBackground(Color.GREEN);
				}

			}
		});
		frame.add(buttonSubmit);
	}

	private void addListSelectWay() {
		Label wayLabel = new Label("Select parser");
		wayLabel.setBounds(50, 100, 100, 30);
		wayLabel.setVisible(true);
		frame.add(wayLabel);

		Choice listWay = new Choice();
		listWay.add("Cli");
		listWay.add("Xml");
		listWay.add("Json");
		listWay.setBounds(50, 130, 100, 20);
		frame.add(listWay);

	}

	private void addMenuBar() {
		MenuBar mb = new MenuBar();

		Menu mainMenu = new Menu("Menu");

		Menu submenu = new Menu("File");

		MenuItem m1 = new MenuItem("Import");
		m1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent var1) {
				JFileChooser jFileChose = new JFileChooser();
				jFileChose.showOpenDialog(new Component() {
				});
				pathFile = jFileChose.getSelectedFile().getAbsolutePath();
			}
		});
		MenuItem m2 = new MenuItem("Exit");

		mb.add(mainMenu);
		mainMenu.add(submenu);
		submenu.add(m1);
		submenu.add(m2);

		frame.setMenuBar(mb);
	}

}
