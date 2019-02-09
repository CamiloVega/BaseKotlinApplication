<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <@kt.addAllKotlinDependencies />

 <#if includeLayout>
        <instantiate from="root/res/layout/fragment_blank.xml.ftl"
                       to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(fragmentName)}.xml" />

        <open file="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(fragmentName)}.xml" />
    </#if>

    <mkdir at="${escapeXmlAttribute(srcOut)}/model" />

<#if isActivity>
<instantiate from="root/src/app_package/Activity.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Activity.${ktOrJavaExt}" />
                   <open file="${escapeXmlAttribute(srcOut)}/${className}Activity.${ktOrJavaExt}" />
</#if>

<#if isFragment>
<instantiate from="root/src/app_package/Fragment.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Fragment.${ktOrJavaExt}" />
                   <open file="${escapeXmlAttribute(srcOut)}/${className}Fragment.${ktOrJavaExt}" />
</#if>

    <instantiate from="root/src/app_package/DisplayData.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/model/${className}DisplayData.${ktOrJavaExt}" />

    <instantiate from="root/src/app_package/ViewModel.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}ViewModel.${ktOrJavaExt}" />
                   
    <instantiate from="root/src/app_package/DataRepository.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}DataRepository.${ktOrJavaExt}" />

    <instantiate from="root/test/app_package/DataRepositoryTest.${ktOrJavaExt}.ftl"
                    to="${escapeXmlAttribute(unitTestOut)}/${className}DataRepositoryTest.${ktOrJavaExt}" />

    <instantiate from="root/test/app_package/ViewModelTest.${ktOrJavaExt}.ftl"
                    to="${escapeXmlAttribute(unitTestOut)}/${className}ViewModelTest.${ktOrJavaExt}" />
                    
    <instantiate from="root/test/app_package/ViewTest.${ktOrJavaExt}.ftl"
                    to="${escapeXmlAttribute(androidTest)}/${className}ViewTest.${ktOrJavaExt}" />

    <open file="${escapeXmlAttribute(srcOut)}/model/${className}DisplayData.${ktOrJavaExt}" />
    <open file="${escapeXmlAttribute(srcOut)}/${className}ViewModel.${ktOrJavaExt}" />
    <open file="${escapeXmlAttribute(srcOut)}/${className}DataRepository.${ktOrJavaExt}" />

</recipe>
