package gui;

import javax.swing.table.AbstractTableModel;

import logic.Igrac;

public class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = -4465403780399873766L;
	private Igrac i;
	public MyTableModel(Igrac i) {
		// TODO Auto-generated constructor stub
		this.i=i;
	}
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return 5;
	}

	@Override
	public String getColumnName(int column) {
		switch(column){
		case 0:
			return "game";
		case 1:
			return i.getIme();
		case 2:
			return "Player 2";
		}
		return null;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(arg0==getRowCount()-1){
			if(arg1==0){
				return "score";
			}
			if(arg1==1){
				i.getUkupnoPoeni();
			}
			if(arg1==2){
				i.getUkupnoPoeniProtivnika();
				
			}
			
			
		}
		if(arg1==0){
				return arg0+1;
		}
		if(arg1==1){
			return 0;
		}
		if(arg1==2){
			return 0;
		}
		return null;
	}
	
	public void azuriraj(){
		fireTableDataChanged();
	}
}
