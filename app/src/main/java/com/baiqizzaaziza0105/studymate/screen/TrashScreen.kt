package com.baiqizzaaziza0105.studymate.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.baiqizzaaziza0105.studymate.model.Tugas
import com.baiqizzaaziza0105.studymate.ui.theme.StudyMateTheme
import com.baiqizzaaziza0105.studymate.util.ViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrashScreen(navController: NavHostController) {

    val context = LocalContext.current
    val factory = ViewModelFactory(context)

    val mainViewModel: MainViewModel =
        viewModel(factory = factory)

    val detailViewModel: DetailViewModel =
        viewModel(factory = factory)

    val deletedData by mainViewModel.deletedData.collectAsState()

    Scaffold(
        topBar = {

            TopAppBar(

                navigationIcon = {

                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {

                        Icon(
                            imageVector =
                                Icons.AutoMirrored.Filled.ArrowBack,

                            contentDescription = "Back"
                        )
                    }
                },

                title = {
                    Text(text = "Recycle Bin")
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =
                        MaterialTheme.colorScheme.primaryContainer,

                    titleContentColor =
                        MaterialTheme.colorScheme.primary
                )
            )
        }

    ) { padding ->

        if (deletedData.isEmpty()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = "Recycle Bin kosong")
            }
        }

        else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {

                items(
                    items = deletedData,
                    key = { it.id }
                ) { tugas ->

                    TrashItem(
                        tugas = tugas,

                        onRestore = {
                            detailViewModel.restore(tugas.id)
                        }
                    )

                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
fun TrashItem(
    tugas: Tugas,
    onRestore: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = tugas.judul,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = tugas.deskripsi,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Text(text = tugas.mataKuliah)

            Text(text = tugas.tanggal)

            IconButton(
                onClick = {
                    onRestore()
                }
            ) {

                Icon(
                    imageVector = Icons.Filled.Restore,
                    contentDescription = "Restore",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun TrashPreview() {

    StudyMateTheme {
        TrashScreen(rememberNavController())
    }
}