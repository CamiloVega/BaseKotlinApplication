<?xml version="1.0"?>
<globals>
<#include "../common/globals.xml.ftl" />
<#assign useSupport=appCompat>
    <global id="useSupport" type="boolean" value="${useSupport?string}" />
    <global id="SupportPackage" value="${useSupport?string('.support.v4','')}" />
 <global id="resOut" value="${resDir}" />
 <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />
 <#include "root://activities/common/kotlin_globals.xml.ftl" />
</globals>