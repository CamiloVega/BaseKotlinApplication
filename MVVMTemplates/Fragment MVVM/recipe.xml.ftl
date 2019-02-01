<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <@kt.addAllKotlinDependencies />

 <#if includeLayout>
        <instantiate from="root/res/layout/fragment_blank.xml.ftl"
                       to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(fragmentName)}.xml" />

        <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(fragmentName)}.xml" />
    </#if>

    <instantiate from="root/src/app_package/ViewModel.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}ViewModel.${ktOrJavaExt}" />

    <instantiate from="root/src/app_package/Fragment.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Fragment.${ktOrJavaExt}" />
                   
    <instantiate from="root/src/app_package/DataRepository.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}DataRepository.${ktOrJavaExt}" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Fragment.${ktOrJavaExt}" />
    <open file="${escapeXmlAttribute(srcOut)}/${className}ViewModel.${ktOrJavaExt}" />
    <open file="${escapeXmlAttribute(srcOut)}/${className}DataRepository.${ktOrJavaExt}" />
</recipe>
