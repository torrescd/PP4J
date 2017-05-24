package net.viktorc.pspp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An abstract implementation of the {@link net.viktorc.pspp.Submission} interface.
 * 
 * @author A6714
 *
 */
public abstract class AbstractSubmission implements Submission {

	private final List<Command> commands;
	private final boolean terminateProcessAfterwards;
	
	/**
	 * Constructs an instance according to the specified parameters.
	 * 
	 * @param commands A list of commands to execute. It should not contain null references.
	 * @param terminateProcessAfterwards Whether the process should be terminated after the execution of the commands.
	 * @throws IllegalArgumentException If the commands are null or empty or contain at least one null reference.
	 */
	public AbstractSubmission(List<Command> commands, boolean terminateProcessAfterwards) {
		if (commands == null || commands.isEmpty())
			throw new IllegalArgumentException("The commands cannot be null.");
		if (commands.isEmpty())
			throw new IllegalArgumentException("The commands cannot be empty.");
		if (!commands.stream().filter(c -> c == null).collect(Collectors.toList()).isEmpty())
			throw new IllegalArgumentException("The commands cannot include null references.");
		this.commands = new ArrayList<>(commands);
		this.terminateProcessAfterwards = terminateProcessAfterwards;
	}
	@Override
	public List<Command> getCommands() {
		return new ArrayList<>(commands);
	}
	@Override
	public boolean doTerminateProcessAfterwards() {
		return terminateProcessAfterwards;
	}

}