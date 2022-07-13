package com.asifddlks.appscheduler.utility

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.asifddlks.appscheduler.installedAppModule.viewModel.InstalledAppViewModel
import com.tvl.stockx.investingTabModule.contractor.InstalledAppViewInterface

//
// Created by Asif Ahmed on 13/7/22.
//

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val viewInterface : Any,
    private val application: Application?,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(InstalledAppViewModel::class.java) -> {
                InstalledAppViewModel(viewInterface as InstalledAppViewInterface)
            }
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}
