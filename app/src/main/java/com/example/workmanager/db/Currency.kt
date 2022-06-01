package com.example.workmanager.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
class Currency {
    @PrimaryKey
    var id: Int? = null
    @ColumnInfo(name = "code")
    var Code: String? = null
    @ColumnInfo(name = "ccy")
    var Ccy: String? = null
    @ColumnInfo(name = "ccy_nm_ru")
    var CcyNm_RU: String? = null
    @ColumnInfo(name = "ccy_nm_uz")
    var CcyNm_UZ: String? = null
    @ColumnInfo(name = "ccy_nm_uzc")
    var CcyNm_UZC: String? = null
    @ColumnInfo(name = "ccy_nm_en")
    var CcyNm_EN: String? = null
    @ColumnInfo(name = "nominal")
    var Nominal: String? = null
    @ColumnInfo(name = "rate")
    var Rate: String? = null
    @ColumnInfo(name = "diff")
    var Diff: String? = null
    @ColumnInfo(name = "date")
    var Date: String? = null

    constructor()
    constructor(
        Code: String?,
        Ccy: String?,
        CcyNm_RU: String?,
        CcyNm_UZ: String?,
        CcyNm_UZC: String?,
        CcyNm_EN: String?,
        Nominal: String?,
        Rate: String?,
        Diff: String?,
        Date: String?
    ) {
        this.Code = Code
        this.Ccy = Ccy
        this.CcyNm_RU = CcyNm_RU
        this.CcyNm_UZ = CcyNm_UZ
        this.CcyNm_UZC = CcyNm_UZC
        this.CcyNm_EN = CcyNm_EN
        this.Nominal = Nominal
        this.Rate = Rate
        this.Diff = Diff
        this.Date = Date
    }


}
