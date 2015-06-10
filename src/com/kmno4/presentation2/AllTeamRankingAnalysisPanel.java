package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.Zone;

import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.PlayerDetailPanel;
import com.kmno4.presentation.TableContentTransfer;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;
/**
 * 全球队信息的球队排名一览界面
 * 按东西联盟分排
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamRankingAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	private AllTeamRankingAnalysisPanel allTeamRankingAnalysisPanel;
	private static final int 
	    LABEL_HEIGHT = 40,
	    TABLE_HEIGHT = (AllTeamDataAnalysisPanel.PANEL_HEIGHT - 2 * LABEL_HEIGHT) / 2;
	private JLabel eastLabel, westLabel;
	private TableGroup eastTg, westTg;
	
	public AllTeamRankingAnalysisPanel(AllTeamDataAnalysisFrame f) {
		this.allTeamDataAnalysisFrame = f;
		this.allTeamRankingAnalysisPanel = this;
		setOpaque(false);
		setLayout(null);
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
				AllTeamRecentMatchAnalysisPanel.example,
				//TableContentTransfer.transferTeamRanking(MainFrame.mainFrame.bl.getTeamRankings(Config.LASTEST_SEASON, Zone.E)),
				getWidth(), TABLE_HEIGHT,
				0, LABEL_HEIGHT/*, rowHeight, headRowHeight, unitWidth*/);
		PlayerDetailPanel.paintTable(eastTg.table);
		
		westLabel = new JLabel("西部联盟");
		westLabel.setBounds(0, LABEL_HEIGHT + TABLE_HEIGHT, getWidth(), LABEL_HEIGHT);
		westLabel.setOpaque(true);
		westLabel.setBackground(new Color(128, 128, 128, 150));
		westLabel.setForeground(Color.white);
		westLabel.setFont(new Font("default", 0, 15));
		add(westLabel);
		westTg = new TableGroup();
		TableFactory.createTable(westTg, this,
				AllTeamRecentMatchAnalysisPanel.example,
//				TableContentTransfer.transferTeamRanking(MainFrame.mainFrame.bl.getTeamRankings(Config.LASTEST_SEASON, Zone.W)),
				getWidth(), TABLE_HEIGHT,
				0, LABEL_HEIGHT * 2 + TABLE_HEIGHT/*, rowHeight, headRowHeight, unitWidth*/);
		//TODO 
		PlayerDetailPanel.paintTable(westTg.table);
		
	}
}
