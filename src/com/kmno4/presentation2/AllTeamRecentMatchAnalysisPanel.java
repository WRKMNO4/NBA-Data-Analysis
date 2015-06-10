package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.PlayerDetailPanel;
import com.kmno4.presentation.TableContentTransfer;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;
/**
 * 全球队信息的最近10场比赛数据分析界面
 * 与联盟排名一览界面结构大体相同
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamRecentMatchAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	private AllTeamRecentMatchAnalysisPanel allTeamRecentMatchAnalysisPanel;
	private static final int 
		LABEL_HEIGHT = 40,
		TABLE_HEIGHT = (AllTeamDataAnalysisPanel.PANEL_HEIGHT - 2 * LABEL_HEIGHT) / 2;
	private JLabel eastLabel, westLabel;
	private TableGroup eastTg, westTg;

	public static final String[][] example = {
			{"lalal", "", "胜", "负", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"},
			{"111", "ccc", "胜", "负", "aa", "b", "cc", "d", "e", "ff", "g", "h", "i", "jy", "k"},
			{"222", "kaka", "胜", "负", "aa", "b", "c", "dd", "e", "f", "g", "h", "ig", "j", "ks"},
			{"333", "baba", "胜", "负", "aa", "b", "cc", "d", "e", "f", "gh", "h", "i", "jh", "k"}};

	public AllTeamRecentMatchAnalysisPanel(AllTeamDataAnalysisFrame f) {
		this.allTeamDataAnalysisFrame = f;
		this.allTeamRecentMatchAnalysisPanel = this;
		setLayout(null);
		setOpaque(false);
		setBounds(AllTeamDataAnalysisPanel.PADDING,
				2 * AllTeamDataAnalysisPanel.PADDING + AllTeamDataAnalysisPanel.SELECT_PANEL_HEIGHT + AllTeamDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * AllTeamDataAnalysisPanel.PADDING,
				AllTeamDataAnalysisPanel.PANEL_HEIGHT);
		
		eastLabel = new JLabel("东部联盟");
		eastLabel.setBounds(0, 0, getWidth(), LABEL_HEIGHT);
		eastLabel.setOpaque(true);
		eastLabel.setBackground(new Color(128, 128, 128, 150));
		eastLabel.setForeground(Color.white);
		eastLabel.setFont(new Font("default", 0, 15));
		add(eastLabel);
		eastTg = new TableGroup();
		TableFactory.createTable(eastTg, this,
				TableContentTransfer.transferAnalysisOfLatest10Matches(MainFrame.mainFrame.teams),
				getWidth(), TABLE_HEIGHT,
				0, LABEL_HEIGHT/*, rowHeight, headRowHeight, unitWidth*/);
		PlayerDetailPanel.paintTable(eastTg.table);
//		TODO
		westLabel = new JLabel("西部联盟");
		westLabel.setBounds(0, LABEL_HEIGHT + TABLE_HEIGHT, getWidth(), LABEL_HEIGHT);
		westLabel.setOpaque(true);
		westLabel.setBackground(new Color(128, 128, 128, 150));
		westLabel.setForeground(Color.white);
		westLabel.setFont(new Font("default", 0, 15));
		add(westLabel);
		westTg = new TableGroup();
		TableFactory.createTable(westTg, this, example, getWidth(), TABLE_HEIGHT,
				0, LABEL_HEIGHT * 2 + TABLE_HEIGHT/*, rowHeight, headRowHeight, unitWidth*/);
		PlayerDetailPanel.paintTable(westTg.table);
		
	}
}
