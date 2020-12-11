import java.util.Scanner; //melakukan import fungsi untuk scanner

class Node //class untuk Node
{
	// membuat class untuk node/simpul
	String tampmenu;
	Node next;
}

public class kelompok_7_bayu_rahman_agung
{
	public static void main(String[] args)
	{
		String pass;
		
		int tanggal[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
    	String hari[]={"kamis","jumat","sabtu","minggu","senin","selasa","rabu","kamis","jumat","sabtu","minggu","senin","selasa","rabu","kamis","jumat","sabtu","minggu","senin","selasa","rabu","kamis","jumat","sabtu","minggu","senin","selasa","rabu","kamis","jumat"};
    	int bis[]={5,4,4,3,6,5,5,5,4,4,3,6,5,5,5,4,4,3,6,5,5,5,4,4,3,6,5,5,5,4};
    	int tiket[]={100,150,300,40,100,250,50,70,100,300,400,80,60,100,350,100,150,300,40,100,250,50,70,100,300,400,80,60,100,350};

		pass = "bus1234";

		//inisialisasi untuk isi data menggunakan linkedlist
		Node current = null;
		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		Node fourth = new Node();

		//membuat menu menggunakan linkedlist
		first.tampmenu = "\n+======SELAMAT DATANG DI INFORMASI RUTE BUS INDRALAYA-PALEMBANG=====+\n";
		first.next = second;
		second.tampmenu = "Silahkan anda ingin masuk sebagai : \n";
		second.next = third;
		third.tampmenu = "1. Penyedia layanan bus ";
		third.next = fourth;
		fourth.tampmenu = "2. Pengguna layanan bus \n";
		fourth.next = null;
		current = first;

		//menampilkan isi dari data 
		while (current != null)
		{
			System.out.println(current.tampmenu);
			current = current.next;
		}


		Scanner input = new Scanner(System.in);
		
		//input pilihan masuk
		System.out.print("masukan pilihan anda 1/2 : ");
		String pilihanmasuk = input.nextLine();
		
		//pengkondisian untuk pilhan masuk
		switch (pilihanmasuk)
		{
			case "1" :
				// jika masuk sebagai penyedia layanan bus
				menupenyedia(pass);
				break;
			
			case "2" :
				// jika memilih sebagai pengguna
				menupengguna(tanggal,hari,bis,tiket);
				break;
			
			default :
				System.out.println("pilihan anda tidak ada");
		}
	}
	public static void menupenyedia(String pass) //menu penyedia
	{
		pass = "bus1234"; //inisialisasi password
		Scanner input = new Scanner(System.in);
		
		//melakukan input untuk penyedia layanan
		System.out.println("masukan password : ");
		String password = input.nextLine();
		
		//pengkondisian input password dengan password sebenarnya
		if (password.equals(pass))
		{
			int i, a;
			int jumlahhari;

			//masukan bulan yang akan diinput
			System.out.println("\nmasukan bulan : ");
			String namabulan = input.next();
			
			//masukan jumlah hari dalam bulan yang diinput
			System.out.println("masukan jumlah hari : ");
			jumlahhari = input.nextInt();

			String[] hari = new String[jumlahhari];
			int[] jumlahtiket = new int [jumlahhari];

			passbenar(hari,jumlahtiket,jumlahhari);
		}
		else
		{
			//output jika password salah
			System.out.println("password yang anda masukan salah");
		}
	}
	public static void passbenar(String[] hari, int[] jumlahtiket,int jumlahhari) //method apabila password benar
	{ 
		int i;
		
		Scanner input = new Scanner(System.in);
		
		//input untuk data hari dan jumlah tiket
		for (i=0; i<jumlahhari; i++)
		{
			System.out.println("hari ke-"+(i+1));
			
			System.out.print("masukan hari dan tanggal (nama hari/tanggal) = ");
			hari[i] = input.next();
			
			System.out.print("masukan jumlah tiket = ");
			jumlahtiket[i] = input.nextInt();
		}
		
		//menu untuk melihat prediksi bus
		System.out.println("Lihat informasi prediksi bus\n");
	
		System.out.println("masukan pilihan (ya/tidak) : ");
		String pilihan = input.next();
		
		//pengkondisian apabila pilihan ya atau tidak
		if (pilihan.equals("ya"))
		{
			sort(hari,jumlahtiket);
		}
		else
		{
			System.out.println("tidak melihat tingkat keramaian");
		}
	}
	public static void sort (String[] hari, int[] jumlahtiket) //method sorting
	{
		int i, j, temp;
		
		//mengurutkan data yang telah diinput menggunakan bubble sort
		for (i = 0; i < jumlahtiket.length; i++)
		{
			for (j=0; j < jumlahtiket.length-1; j++)
			{
				if(jumlahtiket[j] < (jumlahtiket[j+1]))
				{
					int swapInt = jumlahtiket[j];
					jumlahtiket[j] = jumlahtiket[j+1];
					jumlahtiket[j+1] = swapInt;
					String swapString = hari[j];
					hari[j] = hari[j+1];
					hari[j+1] = swapString;
				}
			}
		}
		
		//menampilkan data yang telah diurutkan dari yang terbesar sampai yang terkecil
		System.out.println("No		hari/tanggal			jumlah tiket	  ");
		for(i=0; i<jumlahtiket.length; i++)
		{
			System.out.println((i+1)+"		"+hari[i]+"				"+jumlahtiket[i]+" tiket	");
		}
		
		//menampilkan hari dengan penjualan tiket terbanyak dan terdikit
		System.out.println("");
		System.out.println("hari terpadat adalah hari "+hari[0]+" dengan jumlah penumpang "+jumlahtiket[0]+" orang");
		System.out.println("hari tersepi adalah hari "+hari[hari.length-1]+" dengan jumlah penumpang "+jumlahtiket[jumlahtiket.length-1]+" orang");
	}
	public static void menupengguna(int tanggal[],String hari[],int bis[],int tiket[]) //method menu pengguna
	{
		Scanner input = new Scanner(System.in);
		float rata2Tiket,jumlahTiket = 0;
		int z,cariTanggal,rata2Bis,counter = 0,jumlahBis = 0;
		boolean temukan = false;
		String cariHari;

		//menginput hari dan tanggal yang akan dicek
		System.out.print("\nmasukkan hari yang akan di cek :");
    	cariHari = input.next();

    	System.out.print("masukkan tanggal yang akan di cek :");
    	cariTanggal = input.nextInt();

    	//menampilkan data hari dan tanggal yang dicari
    	System.out.println("\nMenampilkan data informasi keramaian Pada hari " + cariHari+ " tanggal "+cariTanggal +" :");

    	// cek rata rata penggunaan bis hari tertentu bulan sebelumnya
        for(int index=0; index<hari.length; index++)
        {
            if(hari[index].equals(cariHari))
            {
                temukan = true;
                z=index+1;

                jumlahBis = jumlahBis+bis[index];
                jumlahTiket = jumlahTiket+tiket[index];

                counter++;
            }
        }
        
        if(temukan == false)

        {
            System.out.println("Data tidak ditemukan");
        }
        
        //rata2
        rata2Tiket = jumlahTiket/counter;
        rata2Bis = jumlahBis/counter;


        // pengelompokan jenis keramaian
        if(rata2Tiket<= 50)
        {
        	System.out.println("\nDiperkirakan penumpang akan sepi ");
        	System.out.println("Dengan ketersediaan "+rata2Bis+ "bus");
        }
        else if(rata2Tiket > 50 && rata2Tiket<150)
        {
        	System.out.println("\nDiperkirakan penumpang akan tidak terlalu rame, namun tidak terlalu sepi" );
        	System.out.println("Dengan ketersediaan "+rata2Bis+ "bus");
        }
        else
        {
        	System.out.println("\nDiperkirakan penumpang akan rame ");
        	System.out.println("Dengan ketersediaan "+rata2Bis+ " bus");
        }
	}
}