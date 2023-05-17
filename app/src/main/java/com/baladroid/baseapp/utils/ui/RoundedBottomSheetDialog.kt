package com.baladroid.baseapp.utils.ui

import android.app.Dialog
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class RoundedBottomSheetDialog : BottomSheetDialogFragment() {
    // override fun getTheme(): Int = R.style.BaseBottomSheetDialog

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

}