package com.kernelpanic.nfcbanksim

import com.kernelpanic.nfcbanksim.Cards.generateCardNumber
import com.kernelpanic.nfcbanksim.Database.BankDatabase
import com.kernelpanic.nfcbanksim.GET.GetCard
import com.kernelpanic.nfcbanksim.GET.GetClient
import com.kernelpanic.nfcbanksim.GET.GetTransactions
import com.kernelpanic.nfcbanksim.POST_PUT.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicLong

@RestController
class GetController {
    val db = BankDatabase()


//    CLIENT
    @GetMapping("users/{login}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserByLogin(@PathVariable login: String) : GetClient {
        return db.getByLogin(login)
    }


//    CLIENTS


//    ACCOUNT


//    ACCOUNTS


//    CARD
    @CrossOrigin(origins = ["https://ampervolt.putelita.pl","https://kernelpanic.putelita.pl"])
    @GetMapping("/card/{uuid}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getCardFromUUID(@PathVariable uuid: String): GetCard {
        return db.getCardByUUID(uuid)
    }


//    CARDS


//    TRANSACTION


//    TRANSACTIONS
    @CrossOrigin(origins = ["https://ampervolt.putelita.pl","https://kernelpanic.putelita.pl"])
    @GetMapping("/users/{login}/{account}/transactions", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTransactions(@PathVariable account: String): ArrayList<GetTransactions>{
        return db.getTransactions(account)
    }

}
