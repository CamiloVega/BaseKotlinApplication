<?xml version="1.0"?>
<globals>
<#include "../common/globals.xml.ftl" />
<#assign useSupport=appCompat>
    <global id="useSupport" type="boolean" value="${useSupport?string}" />
    <global id="SupportPackage" value="${useSupport?string('.support.v4','')}" />
 <global id="resOut" value="${resDir}" />
 <global id="testOut" value="${testDir}/${slashedPackageName(packageName)}" />
 <global id="androidTest" value="${escapeXmlAttribute(projectOut)}/src/androidTest/java/${slashedPackageName(packageName)}" />
 <global id="unitTestOut" value="${escapeXmlAttribute(projectOut)}/src/test/java/${slashedPackageName(packageName)}" />
 <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />
 <global id="modelDirectory" value="${srcDir}/${slashedPackageName(packageName)}/model" />
 <#include "root://activities/common/kotlin_globals.xml.ftl" />
</globals>