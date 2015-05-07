package com.kmno4.presentation;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.ExitLabel;

@SuppressWarnings("serial")
public class TeamDetailFrame extends JFrame {
	
	public JPanel teamDetailPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamDetailFrame frame = new TeamDetailFrame(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeamDetailFrame(TeamPO teamPO) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(
				MainFrame.mainFrame.getX(),
				MainFrame.mainFrame.getY(),
				MainFrame.mainFrame.getWidth(),
				MainFrame.mainFrame.getHeight());
		setLayout(null);
		setUndecorated(true);
		setBackground(Color.white);
		JLabel close = new ExitLabel(this);
		add(close);
		teamDetailPanel = new TeamDetailPanel(teamPO, this);
		this.add(teamDetailPanel);
		
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}
}
