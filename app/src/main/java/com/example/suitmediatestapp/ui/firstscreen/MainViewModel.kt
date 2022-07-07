package com.example.suitmediatestapp.ui.firstscreen

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    fun isPalindrome(palindrome: String) : Boolean {
        val textWithoutSpace = palindrome.replace("\\s".toRegex(), "")
        val reverseString = textWithoutSpace.reversed()
        return textWithoutSpace.equals(reverseString, ignoreCase = true)
    }

}