package br.com.jvcm.storepreference.query

import br.com.jvcm.storepreference.dto.ClientDTO

class EditContractPresenter(val view: EditClientContract.View) : EditClientContract.Presenter {
    override fun verifyForm() {
        var model = ClientDTO()
        view.onEditClient()
    }
}