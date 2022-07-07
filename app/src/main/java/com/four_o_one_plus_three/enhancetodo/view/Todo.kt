package com.four_o_one_plus_three.enhancetodo.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.asLiveData
import androidx.navigation.NavController
import arrow.core.Option
import com.four_o_one_plus_three.enhancetodo.db.TodoEntity
import com.four_o_one_plus_three.enhancetodo.navigation.Pages
import com.four_o_one_plus_three.enhancetodo.trait.THomeComposeScreen
import com.four_o_one_plus_three.enhancetodo.util.background
import com.four_o_one_plus_three.enhancetodo.util.getComplementColor
import com.four_o_one_plus_three.enhancetodo.viewmodel.TodoVM
import kotlinx.coroutines.launch

object Todo : THomeComposeScreen<TodoVM> {
    override val tag: String = "Todo"

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Screen(vm: Option<TodoVM>) {
        val scope = rememberCoroutineScope()
        val state = vm.map { it.state.collectAsState() }
        val stateAdder = { vm.tap { scope.launch { it.state.emit(it.state.value + 1) } } }
        Scaffold(floatingActionButton = {
            FloatingActionButton(onClick = { stateAdder() }) {
                Icon(ImageBitmap.imageResource(id = android.R.drawable.ic_input_add), null)
            }
        }) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                item {
                    TodoSticker(entity = TodoEntity(content = "hi"))
                }
                item {
                    TodoSticker(entity = TodoEntity(content = "bye", backgroundColor = "#142536"))
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TodoSticker(entity: TodoEntity) {
        val ctx = LocalContext.current
        val bgColor = Color(android.graphics.Color.parseColor(entity.backgroundColor))
        Card(
            elevation = CardDefaults.elevatedCardElevation(5.dp,5.dp,5.dp,5.dp,5.dp,5.dp),
            onClick = { Toast.makeText(ctx, entity.content, Toast.LENGTH_SHORT).show() },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 300.dp, max = 300.dp)
                .padding(5.dp, 10.dp)
        ) {
            Text(
                text = entity.content,
                modifier = Modifier
                    .background(bgColor)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(10.dp),
                color = bgColor.getComplementColor()
            )
        }
    }
}