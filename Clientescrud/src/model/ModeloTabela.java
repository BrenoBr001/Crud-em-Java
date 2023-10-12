package model;

import java.util.ArrayList;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {
	private static final String[] colunas = {
		"Id", "CPF/CNPJ", "Nome", "E-mail", "Telefone", "Endereco"};
	
	
	public ModeloTabela(ArrayList<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}

	private ArrayList<Cliente> clientes;
	@Override
	public int getRowCount() {
		
		return clientes.size();
	}

	@Override
	public int getColumnCount() {
		
		return colunas.length;
	}
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = clientes.get(rowIndex);
		if(columnIndex == 0) {
			return cliente.getId();
		}else {
			if(columnIndex == 1) {
				return cliente.getCpfcnpj();
		}else
			if(columnIndex == 2) {
				return cliente.getNome();
			}else
				if(columnIndex == 3) {
					return cliente.getEmail();
				}else
					if(columnIndex == 4) {
						return cliente.getTelefone();
					}else
						if(columnIndex == 5) {
							return cliente.getEndereco();
						}else {
							return null;
						}
		

}
	}
}
