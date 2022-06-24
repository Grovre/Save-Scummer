package github.grovre.saves;

import lombok.Data;
import lombok.NonNull;
import lombok.Value;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

@Data
public class SaveFile implements Serializable {

    private File src;
    private File dstFolder;

    public SaveFile(@NonNull File src, File dstFolder) {
        this.src = src;
        this.dstFolder = dstFolder;

        if (this.dstFolder == null) {
            this.dstFolder = new File(this.src.getParentFile().getAbsolutePath() + "\\scummed");
            if (!this.dstFolder.exists()) {
                boolean folderCreated = this.dstFolder.mkdir();
                if (!folderCreated)
                    throw new RuntimeException("Could not create scummed folder in source directory");
            }
        }

        if (!this.dstFolder.isDirectory())
            throw new RuntimeException("dstFolder at " + this.dstFolder.getAbsolutePath() + " is not a folder");
    }

    public SaveFile(@NonNull File src) {
        this(src, null);
    }

    public void scumSave() throws IOException {
        String srcName = src.getName();
        File saveCopy = new File(getDstFolder().getAbsolutePath() + "\\" + srcName);
        Files.copy(src.toPath(), saveCopy.toPath());
    }
}
