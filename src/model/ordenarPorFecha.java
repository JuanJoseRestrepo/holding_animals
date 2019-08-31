package model;

import java.util.Comparator;

public class ordenarPorFecha implements Comparator<Club> {

	@Override
	public int compare(Club o1, Club o2) {
		
		return o1.getCreationDate().compareTo(o2.getCreationDate());
	}

}
