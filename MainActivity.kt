package com.example.projectutsruth21510011

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
import com.example.projectutsruth21510011.ui.theme.ProjectUTSRuth21510011Theme
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectUTSRuth21510011Theme {
                // Surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodCard()
                }
            }
        }
    }
}

data class Food(val imageResource: Int, val title: String, val description: String)

@Composable
fun FoodCard() {
    var currentFoodIndex by remember { mutableStateOf(0) }
    var isDescriptionVisible by remember { mutableStateOf(false) }

    // List of Sumatra's traditional foods to display
    val foodList = listOf(
        Food(
            R.drawable.kembangsepatu,
            "Pempek",
            "Pempek adalah hidangan tradisional dari Indonesia, khususnya dari Palembang, Sumatra Selatan. Hidangan ini sangat populer di Indonesia dan dikenal dengan rasa yang unik dan beragam jenisnya. Berikut adalah deskripsi tentang pempek:\n" +
                    "\n" +
                    "1. *Komposisi Utama*: Pempek terbuat dari bahan dasar ikan, biasanya ikan tenggiri, yang dihaluskan menjadi pasta dan dicampur dengan sagu, garam, dan beberapa bumbu lainnya. Adonan ini kemudian dibentuk menjadi berbagai bentuk, seperti bola, tabung, atau segitiga, tergantung pada variasi pempek.\n" +
                    "\n" +
                    "2. *Kekayaan Rasa*: Salah satu hal yang paling mencolok tentang pempek adalah beragam variasi rasa yang ditawarkan. Ada beberapa jenis pempek, termasuk pempek kapal selam (dengan telur rebus di dalamnya), pempek lenjer (berbentuk stik), pempek keriting (kerucut), dan pempek adaan (berisi campuran ikan dan sagu). Semua jenis pempek ini disajikan dengan kuah cuko, yang merupakan saus pedas manis yang terbuat dari gula, cuka, dan bumbu-bumbu lainnya.\n" +
                    "\n" +
                    "3. *Pencelupan dalam Kuah Cuko*: Pempek biasanya disajikan dengan mencelupkannya dalam kuah cuko yang lezat. Kuah cuko ini adalah kunci untuk menciptakan kontras rasa manis, pedas, dan asam yang membuat pempek begitu menggugah selera.\n" +
                    "\n" +
                    "4. *Tekstur Unik*: Pempek memiliki tekstur yang unik. Bagian luar pempek biasanya kenyal dan memiliki lapisan kulit yang agak kering, sementara bagian dalamnya lembut dan berisi.\n" +
                    "\n" +
                    "5. *Hidangan Populer*: Pempek adalah hidangan populer di seluruh Indonesia, terutama di daerah-daerah yang dekat dengan Palembang. Selain disajikan di restoran dan penjual kaki lima, pempek juga sering dijual oleh pedagang keliling yang menggunakan gerobak di sepanjang jalan.\n" +
                    "\n" +
                    "6. *Hidangan Tradisional dan Pesta*: Pempek sering kali disajikan dalam pesta dan acara-acara khusus di Indonesia. Hidangan ini juga sangat cocok untuk disajikan sebagai makanan ringan atau camilan.\n" +
                    "\n" +
                    "Pempek adalah salah satu hidangan Indonesia yang paling terkenal dan unik, dan rasanya yang khas telah membuatnya menjadi favorit di dalam dan di luar negeri."
        ),
        Food(
            R.drawable.mawar,
            "Rendang",
            "Rendang adalah hidangan daging yang sangat terkenal dan berasal dari Indonesia, khususnya dari daerah Sumatra Barat. Hidangan ini dianggap sebagai salah satu makanan tradisional paling terkenal di Indonesia dan telah meraih ketenaran internasional sebagai salah satu makanan paling lezat di dunia. Rendang umumnya terbuat dari potongan daging, seperti daging sapi, yang dimasak dalam rempah-rempah dan santan hingga menjadi kering dan beraroma kuat.\n" +
                    "\n" +
                    "Berikut adalah beberapa ciri khas rendang:\n" +
                    "\n" +
                    "1. *Rasa Kaya Rempah*: Rendang dikenal karena rempah-rempahnya yang kaya. Beberapa bumbu utama yang digunakan dalam rendang antara lain serai, lengkuas, daun kunyit, cabai merah, bawang merah, dan bawang putih. Bumbu ini memberikan hidangan rasa pedas, manis, dan gurih yang mendalam.\n" +
                    "\n" +
                    "2. *Kepadatan*: Rendang adalah hidangan kering, yang berarti daging dimasak hingga semua cairan meresap dan hanya meninggalkan minyak rempah-rempah yang terkonsentrasi di sekitar daging. Hal ini menciptakan struktur dan kepadatan pada hidangan.\n" +
                    "\n" +
                    "3. *Pemanasan Lama*: Salah satu hal yang membuat rendang begitu istimewa adalah cara memasaknya. Daging dimasak dalam santan dan bumbu selama berjam-jam. Proses memasak lambat ini memungkinkan bumbu dan rasa meresap ke dalam daging, menciptakan rasa yang luar biasa.\n" +
                    "\n" +
                    "4. *Makanan Ikonik*: Rendang sering kali dianggap sebagai simbol kekayaan kuliner Indonesia dan bahkan mendapatkan pengakuan dari UNESCO sebagai Warisan Budaya Tak Benda. Ini juga sering disajikan dalam berbagai acara istimewa dan merayakan budaya Indonesia.\n" +
                    "\n" +
                    "5. *Keragaman*: Ada berbagai variasi rendang di seluruh Indonesia, dengan perbedaan dalam tingkat kepedasan dan bumbu. Rendang Sumatra Barat adalah yang paling terkenal, tetapi Anda juga dapat menemui variasi rendang lainnya, seperti rendang Padang dan rendang Minang.\n" +
                    "\n" +
                    "Rendang adalah hidangan yang lezat, kaya rasa, dan menggugah selera. Selain itu, rendang juga merupakan salah satu makanan yang merepresentasikan kekayaan budaya Indonesia yang beragam."
        ),
        Food(
            R.drawable.tulip,
            "Tempoyak",
            "Tempoyak adalah hidangan khas yang berasal dari wilayah Sumatra, Indonesia, dan juga ditemukan di beberapa negara tetangga seperti Malaysia. Hidangan ini sangat khas karena menggunakan bahan utama yang tidak biasa, yaitu durian. Berikut adalah deskripsi tentang tempoyak:\n" +
                    "\n" +
                    "1. *Bahan Utama*: Tempoyak terbuat dari durian yang sudah masak. Durian adalah buah tropis yang dikenal dengan aromanya yang kuat dan kontroversial. Dalam pembuatan tempoyak, daging buah durian diambil dan dicincang atau dihancurkan.\n" +
                    "\n" +
                    "2. *Pengolahan*: Setelah daging durian diambil, itu kemudian difermentasi. Biasanya, tempoyak diolah dengan cara yang mirip dengan proses fermentasi untuk menghasilkan makanan seperti tape atau oncom. Fermentasi adalah proses biologis di mana mikroorganisme menguraikan bahan organik, menghasilkan aroma dan rasa yang unik.\n" +
                    "\n" +
                    "3. *Rasa Khas*: Tempoyak memiliki rasa yang sangat khas dan umumnya memiliki cita rasa asam, gurih, dan khas durian. Hidangan ini memiliki aroma yang kuat dan sering kali dianggap sebagai hidangan yang kurang biasa karena rasa durian yang kuat.\n" +
                    "\n" +
                    "4. *Penggunaan dalam Masakan*: Tempoyak sering digunakan dalam masakan tradisional, terutama dalam hidangan-hidangan seperti gulai (semacam kari khas Indonesia) dan sayur-sayuran. Tempoyak dapat digunakan untuk memberikan rasa dan kelezatan khusus pada hidangan-hidangan tersebut.\n" +
                    "\n" +
                    "5. *Penting dalam Kebudayaan*: Tempoyak memiliki peran penting dalam budaya dan masakan Sumatra. Hidangan ini sering dianggap sebagai simbol kekayaan kuliner dan budaya Indonesia.\n" +
                    "\n" +
                    "6. *Kontroversi Aroma*: Meskipun banyak orang mengagumi rasa tempoyak, ada juga yang merasa terganggu oleh aromanya yang kuat dan karakteristik bau durian yang khas. Oleh karena itu, tempoyak biasanya hanya disukai oleh mereka yang telah mengembangkan selera untuk durian.\n" +
                    "\n" +
                    "Tempoyak adalah hidangan yang sangat unik dan memiliki rasa yang khas. Ini adalah salah satu contoh bagaimana makanan tradisional mencerminkan karakteristik khusus dari daerah asalnya dan memiliki peran penting dalam budaya kuliner Indonesia."
        ),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            // Food Image
            val imagePainter: Painter = painterResource(id = foodList[currentFoodIndex].imageResource)
            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clickable { isDescriptionVisible = !isDescriptionVisible }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Food Title
            Text(
                text = foodList[currentFoodIndex].title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Food Description
            Text(
                text = foodList[currentFoodIndex].description,
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Action Buttons (Previous, Next)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        // Action for the Previous button
                        currentFoodIndex = (currentFoodIndex - 1).coerceAtLeast(0)
                        isDescriptionVisible = false
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Previous")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        // Action for the Next button
                        currentFoodIndex = (currentFoodIndex + 1) % foodList.size
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

@Preview(showBackground = true)
@Composable
fun FoodCardPreview() {
    ProjectUTSRuth21510011Theme {
        FoodCard()
    }
}