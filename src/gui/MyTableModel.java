package gui;

import javax.swing.table.AbstractTableModel;

import logic.Igrac;
import logic.ManagerIgre;

public class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = -4465403780399873766L;
	private Igrac i;

	public MyTableModel(Igrac i) {
		// TODO Auto-generated constructor stub
		this.i = i;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub

		return ManagerIgre.igrac().getPoeni().size() + 1;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "game";
		case 1:
			return Igrac.getIme();
		case 2:
			return ManagerIgre.getDrugiIgracIme();
		}
		return null;
	}

	@Override
	public Object getValueAt(int r, int c) {
		if (r == getRowCount() - 1) {
			if (c == 0) {
				return "score";
			}
			if (c == 1) {
				i.getUkupnoPoeni();
			}
			if (c == 2) {
				i.getUkupnoPoeniProtivnika();

			}

		} else {
			if (c == 0) {
				return r + 1;
			}
			if (c == 1) {
				return ManagerIgre.igrac().getPoeni().get(r);
			}
			if (c == 2) {
				return ManagerIgre.igrac().getPoeniProtivnika().get(r);
			}
		}
		return null;
	}

	public void azuriraj() {
		fireTableDataChanged();
	}
}
