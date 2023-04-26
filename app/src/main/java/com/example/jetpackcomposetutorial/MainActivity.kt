package com.example.jetpackcomposetutorial

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //taskList("All Tasks Complete", "Nice Work!")
                    CreateApp()
                    /*
                        contentHeaderImage(
                            getString(R.string.jetpack_compose_tutorial),
                            getString(R.string.jetpack_compose_is_a_modern_toolkit_for_building_native_android_ui_compose_simplifies_and_accelerates_ui_development_on_android_with_less_code_powerful_tools_and_intuitive_kotlin_apis),
                            getString(R.string.jetpack_compose_is_a_modern_toolkit_for_building_native_android_ui_compose_simplifies_and_accelerates_ui_development_on_android_with_less_code_powerful_tools_and_intuitive_kotlin_apis)
                        )
                     */
                }
            }
        }
    }
}

@Composable
fun contentHeaderImage(header: String, textOne: String, textTwo: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = image,
            contentDescription = null,
           // contentScale = ContentScale.Crop
        )
        Content(header, textOne, textTwo)
    }

}
//builds the screen and loads params
@Composable
fun CreateApp(){
    TaskList(
        header = stringResource(R.string.all_tasks_completed),
        message = stringResource(R.string.nice_work),
        imagePainter = painterResource(R.drawable.ic_task_completed)
    )
}
//unused function from previous version
@Composable
fun Content(header: String, textOne: String, textTwo: String, modifier: Modifier = Modifier) {
    Column () {
        Text(
            text = header,
           // modifier = modifier,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 10.dp)

        )
        Text(
            text = textOne,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
        Text(
            text = textTwo,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
    }
}

//task list is called and then then its parameters are filled from when it's called at CreateApp
@Composable
private fun TaskList (header: String, message: String, imagePainter: Painter, modifier: Modifier = Modifier){
   // val checkmark = painterResource(R.drawable.ic_task_completed)
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        Image(
            painter = imagePainter,
            contentDescription = null,
        )
        Text(
            text = header,
            fontSize = 16.sp,
            fontWeight = Bold,
            modifier = modifier
                .padding(top = 10.dp)
        )
        Text(
            text = message,
            fontSize = 16.sp,
            modifier = modifier
                .padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        CreateApp()
        //taskList("All Tasks Completed", "Nice work!")
       // headerImage()
        /*
        contentHeaderImage(
            Resources.getSystem().getString(R.string.jetpack_compose_tutorial),
            Resources.getSystem().getString(R.string.in_this_tutorial_you_build_a_simple_ui_component_with_declarative_functions_you_call_compose_functions_to_say_what_elements_you_want_and_the_compose_compiler_does_the_rest_compose_is_built_around_composable_functions_these_functions_let_you_define_your_app_s_ui_programmatically_because_they_let_you_describe_how_it_should_look_and_provide_data_dependencies_rather_than_focus_on_the_process_of_the_ui_s_construction_such_as_initializing_an_element_and_then_attaching_it_to_a_parent_to_create_a_composable_function_you_add_the_composable_annotation_to_the_function_name),
            Resources.getSystem().getString(R.string.jetpack_compose_is_a_modern_toolkit_for_building_native_android_ui_compose_simplifies_and_accelerates_ui_development_on_android_with_less_code_powerful_tools_and_intuitive_kotlin_apis)
        )
         */
    }
}