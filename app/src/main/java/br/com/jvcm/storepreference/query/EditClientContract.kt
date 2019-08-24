package br.com.jvcm.storepreference.query

interface EditClientContract {
    interface View {
        fun onEditClient()
    }

    interface Presenter{
        fun verifyForm()
    }
}