> between `git revert` and `git reset` :point_right: __prefer using `git revert`__ . because it does not change the history only resets the changes and makes this changes in a new commit in th history . thus does not alter the linear commit history

```
git revert HEAD 	// to go back to the state of the last commit
git revert HEAD~1 	// to go back one 1 commit, exit `vim` editor with "Esc" -> type :q! and enter
git restore .  	 	// to unstage all the changes or for old git version  `git checkout --`
git clean -fd 		// ro remove every added file
```

>`git reset --hard HEAD`
>
>`git log --grep='yourSearchWord`'
>
>`git revert theLogHash`
>
>after doing this , __obviously__ the new files and folders would be `Untracked` and you can see them with `git status` .
>
>so if you wanna delete them now you should use :
>
>```
>git clean -fd
>```
>
>and those files and folders would be removed now

### Using `git reset commitLog`

> for hard reset use `git reset` , __Warning__ this would change the `branching` .
>
> the `git revert` simply goes back and creates a new commit .
>
> but `git reset` would change the branch and commits
>
> `git reset` forgets any new commits __!!__

```
git reset --hard oldCommitHash

// and then to push it to remote branch too , use + plus like :

git push origin +main
```

## Best use `git revert`

If you want to discard all changes since your last commit and return to the state of your files exactly as they were at that commit, you have a couple of options. These methods allow you to undo the most recent commit without affecting the history of your repository, which is safer than using `git reset --hard` and force pushing.

### Option 1: Using `git reset`

The `git reset` command moves the `HEAD` pointer back to a previous commit, effectively "forgetting" any commits that came after it. To undo the most recent commit and keep your changes in the staging area, you can use:

```
git reset --soft HEAD~1
```

This command moves the `HEAD` pointer one commit back (`HEAD~1`) but keeps your changes staged. You can then modify or add more changes as needed before committing again.

If you want to completely discard the changes from the undone commit, you can use:

```
git reset --hard HEAD~1
```

This will move the `HEAD` pointer back by one commit and discard all changes associated with that commit.

### Option 2: Using `git revert`

Another safe method to undo the most recent commit is to use `git revert`. This command creates a new commit that undoes the changes made in the previous commit. It's a non-destructive way to undo changes and is safe to use even if the commit has already been pushed to a shared repository.

To revert the most recent commit, you can use:

```
git revert HEAD
```

This command will open an editor for you to enter a commit message for the new revert commit. If you prefer not to edit the message, you can use the `--no-edit` flag:

```
git revert --no-edit HEAD
```

Both `git reset` and `git revert` are effective ways to undo changes, but they serve slightly different purposes. `git reset` is more suited for local changes and can rewrite history, while `git revert` is safer for undoing changes that have been shared with others.

Choose the method that best fits your situation. If you're working alone and haven't pushed your changes, `git reset` might be quicker. If you've already pushed your changes or are collaborating with others, `git revert` is a safer choice.
