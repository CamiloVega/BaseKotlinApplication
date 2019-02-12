package com.cvdevelopers.baseapplication.api.models

import com.google.gson.annotations.SerializedName

data class ItemSchema (
    @SerializedName("item_id")
    val itemId: Int?,
    @SerializedName("menu_id")
    val menuId: Int?,
    val price: String?,
    val state: String?,
    val cancelled: Boolean?,
    @SerializedName("unit_price")
    val unitPrice: String,
    val id: Int,
    @SerializedName("venue_id")
    val venue_id: Int?,
    val name: String,
    val disabled: Boolean = false,
    @SerializedName("menu_name")
    val menuName: String?,
    val description: String?,
    val position: Int,
    val weight: Int,
    @SerializedName("by_weight")
    val byWeight: Boolean = false,
    @SerializedName("tare_weight")
    val tareWeight: String?,
    val alcohol: Boolean = false,
    val archived: Boolean = false,
    val catalog: String?,
    @SerializedName("category_id")
    val categoryId: Int?,
    @SerializedName("reporting_group_id")
    val reportingGroupId: Int?,
    @SerializedName("image_file_name")
    val imageFileName: String?,
    @SerializedName("tax_group_org")
    val taxGroupOrg: String?, //TODO make sure the type, in the menus I have there is no value for this
    val parts: List<String> = emptyList(), //TODO make sure the type, in the menus I have there is no value for this
    val sku: String?,
    val plu: String?, //TODO make sure the type, in the menus I have there is no value for this
    val upc: String?, //TODO make sure the type, in the menus I have there is no value for this
    @SerializedName("option_types")
    val optionTypes: List<String> = emptyList(), //TODO make sure the type, in the menus I have there is no value for this
    val modifiers: List<ModifierSchema>,
    @SerializedName("tax_rates")
    val taxRates: List<TaxRateSchema>,
    @SerializedName("tax_rate")
    val taxRate: String?,
    @SerializedName("print_group_printer_name")
    val printGroupPrinterName: String?,
    val toppings: List<String> = emptyList(), //TODO make sure the type, in the menus I have there is no value for this
    val sides: List<String> = emptyList(), //TODO make sure the type, in the menus I have there is no value for this
    @SerializedName("tax_inclusive")
    val taxInclusive: Boolean = false,
    @SerializedName("image_url")
    val imageURL: String?,
    val upsales: List<String> = emptyList(), //TODO make sure the type, in the menus I have there is no value for this
    val variants: List<String> = emptyList(), //TODO make sure the type, in the menus I have there is no value for this
    val type: String? //TODO make sure the type, in the menus I have there is no value for this
)
