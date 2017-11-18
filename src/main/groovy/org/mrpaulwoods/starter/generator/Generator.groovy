package org.mrpaulwoods.starter.generator

import java.util.zip.ZipOutputStream

interface Generator {
    void execute(Context context, ZipOutputStream zos)
}