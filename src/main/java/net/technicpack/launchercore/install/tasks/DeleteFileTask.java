package net.technicpack.launchercore.install.tasks;

import net.technicpack.launchercore.install.InstallTasksQueue;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DeleteFileTask implements IInstallTask {
    private final File fileToDelete;

    public DeleteFileTask(File fileToDelete) {
        this.fileToDelete = fileToDelete;
    }

    @Override
    public String getTaskDescription() {
        return fileToDelete.getName();
    }

    @Override
    public float getTaskProgress() {
        return 0;
    }

    @Override
    public void runTask(InstallTasksQueue queue) {
        if (fileToDelete.exists()) {
            try {
                FileUtils.forceDelete(fileToDelete);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
