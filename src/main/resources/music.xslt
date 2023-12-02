<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Albums</title>
            </head>
            <body>
                <h1>Album</h1>
                <table width="80%" margin="auto" border="1px solid black">
                    <tr>
                        <th>Title</th>
                        <th>Release</th>
                    </tr>
                    <xsl:for-each select="music/band/album">
                        <tr>
                            <td><xsl:value-of select="@title"/></td>
                            <td><xsl:value-of select="@released"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
