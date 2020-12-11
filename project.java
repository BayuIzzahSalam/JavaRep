import java.util.Scanner;

public class project
{
	public static void main (String[] args)
	{
		int jmlpeserta;
		int[] nilai;
		String[] nama;
		String[] status;
		Scanner input = new Scanner(System.in);
		
		System.out.print("masukan jumlah peserta = ");
		jmlpeserta = input.nextInt();
		
		nama = new String[jmlpeserta];
		nilai = new int[jmlpeserta];
		status = new String[jmlpeserta];
		
		tabel(nama,nilai,status);
	}
	
	public static void tabel(String[] nama, int[] nilai, String[] status)
	{
		int i, jmlpeserta;
		Scanner input = new Scanner(System.in);
		
		System.out.print("masukan jumlah peserta = ");
		jmlpeserta = input.nextInt();
		
		nama = new String[jmlpeserta];
		nilai = new int[jmlpeserta];
		status = new String[jmlpeserta];
		
		for (i=0; i<jmlpeserta; i++)
		{
			System.out.println("peserta ke-"+(i+1));
			
			System.out.print("nama peserta = ");
			nama[i] = input.next();
			
			
			System.out.print("masukan nilai = ");
			nilai[i] = input.nextInt();
			
		}
		System.out.println("|No\t|\tNama\t|\tNilai\t|  ");
    
		for (i=0; i<jmlpeserta;i++) 
		{
			System.out.println("|"+(i+1)+"\t|\t"+nama[i]+"\t|\t"+nilai[i]+"\t|");
		}
		
		System.out.println("apakah kamu ingin mengurutkan tabel (ya/tidak) ");
		String urutkan = input.next();
		
		if (urutkan.equals("ya"))
		{
			sort(nilai,nama);
		}
		else 
		{
			System.out.println("data tidak diurutkan");
		}
		
		for (i=0; i<nilai.length; i++)
		{
			if (nilai[i] >= 80)
			{
				status[i] = "lulus tingkat nasional";
			}
			else 
			{
				if (nilai[i] >= 70 && nilai[i]<=79)
				{
					status[i] = "lulus tingkat provinsi";
				}
				else 
				{
					status[i] = "tidak lulus seleksi";
				}
			}
		}
		
		System.out.println("|No\t|\tNama\t|\tNilai\t|\tStatus\t\t\t|  ");
		for(i=0; i<nilai.length; i++)
		{
			System.out.println("|"+(i+1)+"\t|\t"+nama[i]+"\t|\t"+nilai[i]+"\t|\t"+status[i]+"\t|");
		}
		
		System.out.println("apakah ingin mencari nama peserta (ya/tidak) ");
		String tanyacari = input.next();
		
		if (tanyacari.equals("ya"))
		{
			search(nama,nilai,status);
		}
		else
		{
			System.out.println("tidak mencari nama");
		}
		
		System.out.println("apakah ingin melihat juara (ya/tidak) ");
		String juara = input.next();
		
		if (juara.equals("ya"))
		{
			tampilperingkat(nama,nilai,status);
		}
		else
		{
			System.out.println("tidak menampilkan peringkat");
		}
	}

	public static void sort(int[] nilai,String[] nama)
	{
		int i, j, temp;
		
		System.out.println("\ndata nilai setelah diurutkan : ");
		
		for (i = 0; i < nilai.length; i++)
		{
			for (j=0; j < nilai.length-1; j++)
			{
				if(nilai[j] < (nilai[j+1]))
				{
					int swapInt = nilai[j];
					nilai[j] = nilai[j+1];
					nilai[j+1] = swapInt;
					String swapString = nama[j];
					nama[j] = nama[j+1];
					nama[j+1] = swapString;
				}
			}
			
		}
	}
	
	public static void search(String[] nama, int[] nilai, String[] status)
	{
		int i;
		boolean ketemu = false;
		Scanner input = new Scanner(System.in);
		
		System.out.print("masukan nama peserta = ");
		String namacari = input.next();
		
		for(i=0; i<nama.length; i++)
		{
			System.out.print(nama[i]+" == "+namacari);
				
			if(nama[i].equals(namacari))
			{
				int hasil=i+1;
				ketemu=true;
				break;
			}
			else
			{
				System.out.println("\t\tData Tidak Cocok");
			}
		}
		if(ketemu==true)
		{
			System.out.println("\nnama peserta "+nama[i]+" dengan nilai "+nilai[i]+" dinyatakan "+status[i]);
		}
		else
		{
			System.out.println("\nData Tidak Ditemukan");
		}
	}
	
	public static void tampilperingkat(String[] nama, int[] nilai, String[] status)
	{
		System.out.println("peringkat 1 adalah "+nama[0]+" dengan jumlah nilai "+nilai[0]+" dan dinyatakan "+status[0]);
		System.out.println("peringkat 2 adalah "+nama[1]+" dengan jumlah nilai "+nilai[1]+" dan dinyatakan "+status[1]);
		System.out.println("peringkat 3 adalah "+nama[2]+" dengan jumlah nilai "+nilai[2]+" dan dinyatakan "+status[2]);
	}
}

