package com.rendox.grocerygenius.feature.icon_picker_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.rendox.grocerygenius.ui.GroceryGeniusTransition

const val ICON_PICKER_ROUTE = "icon_picker_route"
const val PRODUCT_ID_ARG = "edit_grocery_id_arg"
const val ICON_PICKER_ROUTE_WITH_ARGS = "$ICON_PICKER_ROUTE/{$PRODUCT_ID_ARG}"

fun NavController.navigateToIconPicker(
    editGroceryId: String,
    navOptions: (NavOptionsBuilder.() -> Unit) = {},
) {
    this.navigate(
        route = "$ICON_PICKER_ROUTE/$editGroceryId",
        builder = navOptions,
    )
}

fun NavGraphBuilder.iconPickerScreen(
    navigateBack: () -> Unit,
) {
    composable(
        route = ICON_PICKER_ROUTE_WITH_ARGS,
        enterTransition = { GroceryGeniusTransition.SlideInVertically },
        exitTransition = { GroceryGeniusTransition.SlideOutVertically },
    ) {
        IconPickerRoute(
            navigateBack = navigateBack,
        )
    }
}
