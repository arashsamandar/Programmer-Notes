## Important :

#### Resolving The `refspec error` when trying to push to the repository we have `just cloned`, from the branch we just created with `git checkout -b my-new-branch`

> for resolving this error use `git branch -M my-new-branch` when you are in your my-new-branch, the -M changes the name of the branch you are in

```text
git branch -M my-new-branch // it will move or rename the branch to my-new-bran
git branch --set-upstream-to=origin/main main
git merge origin/main --allow-unrelated-histories
// this -M changes the name of the current branch with above command. it can also be used to move a branch
```

### Local branch Tracking remote origin branch

```text
git checkout -b mybranch origin/mybranch
// or below push the branch we are in to the origin/folanBranch
git push -u origin arashsamandarBranch // create and push the origin/branch
// or like below to upload to the remote branch named below
git push origin arashsamandarBranch:remoteBranchName
```

### git pull

> A pull request is a request to the original repository's owner to include your changes in their codebase

### git clone

> is used to create a working copy of a remote repository

### git pull

> like
>
> ```javascript
> git pull origin master //connects origin(http://folan...) to master and pull it
> ```

### git push

> use after you want your code to be written to remote rempository, like bellow :
>
> ```javascript
> git push -u origin master //-u means (upstream)
> ```

### Merge remote with local
```markdown
git merge origin/main --allow-unrelated-histories
```

### See All Branches ( Local & Remote )

```javascript
git branch //shows which branch you are on
git branch -v //shows branchs with there last commits
git branch -a // NOTE : Important and shows all local and remote branches

git branch -d branchName //Deletes a branch
```

### how to change your username in `Git`

> to change your username use `git config`
>
> ```
> git config --global user.name "arash samandar"
> ```

### how to change user email in git

> it is always starts with `git config` , like bellow :
>
> ```
> git config --global user.email youuser@gmail.co
> ```

----------------

> if you wish to see the content inside the directory use :
>
> ```
> ls -a .git
> ```

### how to ChangeUpStream in Git

```tex
git push --set-upstream origin main
// or
git push --set-upstream origin master
// this commands push your commits to main, or master branch of origin (remote )
```

### Create and Go To New Branch

```text
git checkout -b myBranch
```

### checking which branch you are in

```text
git branch
```

### if you want to commit now, you have to change --set-upstream

```text
git remote --set-upstream origin
```

```javascript
// before that you probably have used this :
git remote add origin https:\\github.com\folanuser\folanrepo.git
```

### or you can use `-u` with every push command

```javascript
git push -u theDefaultOrigin theBranch
// like bellow :
git push -u origin master
```

