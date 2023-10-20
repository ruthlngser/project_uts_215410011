package id.utdi.utsruth215410011

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.utdi.utsruth215410011.ui.theme.UTSRuth215410011Theme
import androidx.compose.ui.tooling.preview.Preview

//MainActivity adalah kelas turunan dari `ComponentActivity` yang merupakan komponen inti dalam arsitektur Android. 
//Fungsi `onCreate` di dalamnya menetapkan antarmuka pengguna utama ke `FlowerCard` dengan menggunakan `setContent` dan menerapkan tema dari `UTSRuth215410011Theme`.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTSRuth215410011Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlowerCard()
                }
            }
        }
    }
}

data class Flower(val imageResource: Int, val title: String, val description: String)

@Composable
fun FlowerCard() {
    var currentFlowerIndex by remember { mutableStateOf(0) }
    var isDescriptionVisible by remember { mutableStateOf(false) }

    // Daftar jenis bunga
    val flowerList = listOf(
        Flower(
            R.drawable.kembangsepatu,
            "Kembang Sepatu",
            "Kembang sepatu, atau hibiscus, berasal dari keluarga Malvaceae dan memiliki beragam jenis. " +
                    "Bunganya yang besar dan berwarna cerah membuatnya populer sebagai tanaman hias. " +
                    "Selain itu, beberapa varietas juga memiliki nilai pengobatan dalam tradisi herbal.\n"
        ),
        Flower(
            R.drawable.mawar,
            "Mawar",
            "Mawar, dengan keindahan dan keharumannya, sering dianggap sebagai simbol cinta dan romantika. " +
                    "Bunga ini berasal dari genus Rosa dan hadir dalam berbagai warna seperti merah, putih, kuning, dan merah muda. Selain nilai dekoratif, minyak mawar juga digunakan dalam industri parfum dan kosmetik.\n"
        ),
        Flower(
            R.drawable.tulip,
            "Tulip",
            "Tulip, bunga asli Eropa, terkenal dengan keanggunannya dan sering kali dikaitkan dengan Belanda. " +
                    "Tulip hadir dalam berbagai warna dan varietas, memberikan keindahan luar biasa pada taman. " +
                    "Bunga ini memiliki sejarah panjang sebagai simbol kekayaan dan kemewahan.\n"

        ),
    )
    //`LazyColumn` untuk menampilkan daftar elemen secara efisien, yaitu daftar jenis bunga. 
    // Setiap item di LazyColumn mencakup gambar bunga, nama bunga, deskripsi bunga, dan tombol aksi "Previous" dan "Next".
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            // Gambar Bunga
            val imagePainter: Painter = painterResource(id = flowerList[currentFlowerIndex].imageResource)
            //Menggunakan komponen `Image` untuk menampilkan gambar bunga. Gambar diambil dari resource drawable menggunakan `painterResource`.
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable { isDescriptionVisible = !isDescriptionVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nama Bunga
            Text(
                text = flowerList[currentFlowerIndex].title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Deskripsi Bunga
            Text(
                text = flowerList[currentFlowerIndex].description,
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Aksi (Previous, Next)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        // Sebagai tombol untuk pilihan kembali ke halaman sebelumnya
                        currentFlowerIndex = (currentFlowerIndex - 1).coerceAtLeast(0)
                        isDescriptionVisible = false
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Previous")
                }

                Spacer(modifier = Modifier.width(8.dp))
                
                //Menggunakan tombol `Button` untuk mengaktifkan aksi "Previous" dan "Next". 
                //Selain itu, `clickable` diterapkan pada gambar bunga sehingga deskripsi bunga dapat ditampilkan atau disembunyikan dengan mengklik gambar.
                Button(
                    onClick = {
                        // sebagai tombol untuk aksi selanjutnya
                        currentFlowerIndex = (currentFlowerIndex + 1) % flowerList.size
                        isDescriptionVisible = false
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

//Menggunakan anotasi `@Preview` untuk menampilkan preview antarmuka pengguna (`FlowerCardPreview`) 
//selama pengembangan dalam lingkungan pengembangan (IDE).
@Preview(showBackground = true)
@Composable
fun FlowerCardPreview() {
    UTSRuth215410011Theme {
        FlowerCard()
    }
}

//Dengan adanya aplikasi yang memungkinkan pengguna 
//menjelajahi daftar jenis bunga dengan gambar dan deskripsi yang berubah 
//sesuai dengan tombol "Previous" dan "Next".
