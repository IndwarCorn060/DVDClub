package clases;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DVDClub club = new DVDClub("peliculas.txt","clientes.txt");
		System.out.println(club.getClientes().toString());
		System.out.println(club.getDvds().toString());
		club.alquila("Como Dios", "Jaime Lopez Peña");
		System.out.println(club.getClientes().toString());
		System.out.println(club.getDvds().toString());
	}

}
