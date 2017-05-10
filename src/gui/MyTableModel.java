package gui;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		switch(column){
		case 0:
			return "Partija";
		case 1:
			return "Player 1";
		case 2:
			return "Player 2";
		}
		return null;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
