## How to Unstage

```javascript
git restore . --staged
// or name the file
git restore .env --staged
```

## how to see the `HEAD` ( Commits Made ) in an Specific `branch`

```
git log HEAD..<branch-name>
```

> This command shows the commits that are on the my-new-branch branch but not on the current branch (HEAD). This is useful for seeing what changes have been made on the feature branch since it diverged from the current branch.

### Seeing and Overviewing All The Changes ( Commits ) In Summery

```javascript
git log --oneline branch-name
// for All the Details
git log -p branch-name
```

------

## See Contents Of A __File in a Previous  Commit__

```
git show <the-commit-hash>:<the-file-path>
```

## Pull with Rebase

Alternatively, if you prefer to maintain a linear history without merge commits, you can use the `--rebase` option with the `git pull` command:

```
git pull --rebase origin <branch_name>
```

This command fetches the latest changes from the specified branch and rebases your local branch on top of them, effectively applying your local changes on top of the changes fetched from the remote branch.

--------

## Branch : Set Default Upstream For A Branch

```
git branch --set-upstream-to=origin/latest-branch latest-branch
```

---

## For getting the latest edits from the remote repository

> one of the good ways is to use `git pull` , it is the combination of `git fetch` and `git merge`

```
git pull origin the-remote-branch
```

> another way is to use `git fetch origin` or `git fetch origin remote-branch` . as this one gets all the changes but does not merge them untill your command `git merge origin/remote-branch` or `git merge origin`
>
> __Important Note__ : The command `git fetch origin/folan-branch` gets the latest updates from the remote repository. and it stores them in the `remote-tracking branch` named here `origin/folan-branch`.
>
> then you can do `git merge origin/folan-branch` to merge the last changes into your local environment.

## see the remote tracking branches with

```
git branch -r
// and for local
git branch -v
```

## View Commits Of The Remote Branches

>**View Commits**: To view the commits in the remote tracking branch, you can use `git log origin/folan-branch`. This command shows the commit history of the specified remote tracking branch.

```
git log origin/folan-branch
```

## Compare Changes With The Remote Branch

>If you want to compare the changes between your current branch and the remote tracking branch, you can use `git diff ..origin/folan-branch`. This command shows the differences between the current branch and the specified remote tracking branch.

```
git diff ..origin/folan-branch
```

## **Checkout Remote Tracking Branch**

>Although you cannot directly check out a remote tracking branch (since they are read-only references to the state of the remote branches), you can create a new local branch that tracks the remote branch and then check out this new branch. Use `git checkout -b folan-branch origin/folan-branch` to create and switch to a new branch that tracks the remote branch.

```
git checkout -b folan-branch origin/folan-branch
```

## Remember

>Remember, after fetching changes with `git fetch origin`, the remote tracking branches are updated to reflect the current state of the remote repository. These branches serve as a reference to the remote branches, allowing you to review changes before deciding to merge them into your local branches.

# `git fetch` & `git merge` & `git pull`

> git pull is the sum of `git fetch` followed by `git merge`

### for `git fetch` we have

```
git fetch origin 	// fetch with " " space only, to fetch all repository and branches all at once

git fetch origin folan-branch  	// fetch with space only
get merge origin/folan-branch 	// merge with `/`
```

> this fetch command, like the second one for example . updates the `remote tracking branch` , which is virtual and it's porpuse is : so that you can compare or see it like above examples with `git log origin/folan-branch`
>
> and or merge with, like : `git merge origin/main`

## important 

> after creating a local new branch with `git checkout -b my-new-branch`
>
> you should push to the new desired remote branch with `git push origin my-new-branch`

## Important :

#### Resolving The `refspec error` when trying to push to the repository we have `just cloned`, from the branch we just created with `git checkout -b my-new-branch`

> for resolving this error use `git branch -M my-new-branch` when you are in your my-new-branch, the -M changes the name of the branch you are in.

```text
git branch -M my-new-branch // it will move or rename the branch to my-new-bran

git merge origin/main --allow-unrelated-histories
```

### Local branch Tracking remote origin branch

```text
git checkout -b mybranch origin/mybranch
// or below push the branch we are in to the origin/folanBranch
git push -u origin mybranch
// or like below to upload to the remote branch named below
git push origin arashsamandarBranch:remoteBranchName
```

### git pull

> A pull request is a request to the original repository's owner to include your changes in their codebase

### git clone

> is used to create a working copy of a remote repository

### git pull , git push

> like
>
> ```javascript
> git pull origin master //connects origin(http://folan...) to master and pull it
> ```
> 
>another one is when you want to push to different remote repository like :
> 
>```javascript
> git push origin master
> // or
> git push origin someRemoteBranch
> ```

### git push

> use after you want your code to be written to remote rempository, like bellow :
>
> ```javascript
> git push -u origin master //-u means (--set-upstream)
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

---------

### How to `Stash` , `Pull` , and then Apply changes :

```javascript
git stash
git pull
git stash apply
// or
git stash apply --drop // to both apply the stashed files and then drop ( remove ) all of them
```

## how to undo things

```javascript
git revert HEAD
// or
git revert HEAD~1
git restore . // restores all the changes that are in 'git add .' // or `git checkout -- .` old vrsn
git clean -fd // removes every created file or directory
// or
git reset --hard HEAD // change comment history totally
git clean -fd
git restore .
```

## See Changes Made To A `File`

```javascript
git log --follow filename // shows commits that changes this file
git rm filename // removes the file and adds the change staged for commit
```

## For a Repository

fork a repository in the site at one of the addresses :

> mkdir myforkedrepository .
> cd myforkedrepository
> git clone https://github.com/gituser/gituserrepository.git
> git checkout -b my_fixes_to_the_repository
> nano folanfileofrepository.js
> make changes in nano and save it
> git commit -am "i fixed one of your bugs, == should be ==="
> git remote --set-upstream https://github.com/gituser/gitfolanrepo.git
> git remote add origin https://github.com/gituser/gitrepo.git // maybe this or above
> git push
> if didn't work , set the default with -M
> git branch -M my_fixes_to_the_repository
> git push

> then go to your forked repository
> push the pull request button . and then submit it for their review
