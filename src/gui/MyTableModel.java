package gui;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4465403780399873766L;

	public MyTableModel() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public String getColumnName(int column) {
		switch(column){
		case 0:
			return "game";
		case 1:
			return "Player 1";
		case 2:
			return "Player 2";
		}
		return null;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(arg0==getRowCount()-1 && arg1==0){
			return "score";
			
		}
		if(arg1==0){
				return arg0+1;
		}
		
		return 0;
	}

}
