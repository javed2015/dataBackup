package test;
/*
   Copyright 2013, 2014 Dominik Stadler
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.errors.RepositoryNotFoundException;

//import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.BaseRepositoryBuilder;


public class CookBookHelper {

    public static Repository openJGitCookbookRepository() throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build();
        return repository;
    }

    public static Repository createNewRepository() throws IOException {
    	
    	String path = "C:\\VOTSH";
		File index = new File(path);
        // prepare a new folder
        File localPath = File.createTempFile("NewRepository", "",index);
        localPath.delete();

        // create the directory
        Repository repository = FileRepositoryBuilder.create(new File(localPath, ".git"));
        repository.create();

        return repository;
    }
}
