package com.rendox.grocerygenius.screens.grocery_list

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rendox.grocerygenius.ui.GroceryGeniusTransition

const val GROCERY_LIST_ID_ARG = "groceryListId"
const val GROCERY_LIST_ROUTE = "grocery_list_route"

fun NavController.navigateToGroceryList(
    listId: String,
    navOptions: NavOptionsBuilder.() -> Unit = {},
) {
    this.navigate(
        route = "$GROCERY_LIST_ROUTE/$listId",
        builder = navOptions,
    )
}

fun NavGraphBuilder.groceryListScreen(
    navigateBack: () -> Unit,
    defaultListId: String?,
) {
    composable(
        route = "$GROCERY_LIST_ROUTE/{$GROCERY_LIST_ID_ARG}",
        arguments = listOf(
            navArgument(GROCERY_LIST_ID_ARG) {
                type = NavType.StringType
                defaultValue = defaultListId ?: ""
            },
        ),
        enterTransition = {
            GroceryGeniusTransition.sharedZAxisEnterForward
        },
        exitTransition = {
            GroceryGeniusTransition.sharedZAxisExitBackward
        },
    ) {
        GroceryListRoute(
            navigateBack = navigateBack,
        )
    }
}